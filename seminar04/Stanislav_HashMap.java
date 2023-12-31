//    Оксана, добрый день! Это задание придумал я, предполагается, что вы уже изучали язык Java, хотя бы в рамках начального курса, я сам проводил все начальные курсы и на одном из уроков по начальному курсу проходят понятие итератора, добавить сам итератор в программу можно, представьте себе, у вас есть массив бакетов, перебор всех элементов сводится к тому что бы пройти по всем элементам массива и каждому узлу бакета в частности и.... все. Да, звучит просто, реализация хитрая но не что-то запредельное, я постараюсь вам показать. Для начала наследуем класс HashMap от интерфейса итератора:


    public class HashMap<K, V> implements Iterable<HashMap.Entity>
//Тут, элементом коллекции HashMap выступает Entity, который содержит ключ + значение, имплементируем интерфейс:

    public class HashMap<K, V> implements Iterable<HashMap.Entity> {

        private static final int INIT_BUCKET_COUNT = 16;

        private Bucket[] buckets;
        private Bucket.Node currentNode;
        private int currentIndex;

        @Override
        public Iterator<HashMap.Entity> iterator() {
            return new HashMapIterator();
        }
//        Создаем класс HashMapIterator, имплементирующий интерфейс Iterator<HashMap.Entity>:

        class HashMapIterator implements Iterator<HashMap.Entity>{

            @Override
            public boolean hasNext() {
                if (currentNode == null){
                    for (int i = 0; i < buckets.length; i++)
                        if (buckets[i] != null && buckets[i].head != null){
                            currentIndex = i;
                            currentNode = buckets[i].head;
                            return true;
                        }
                    return false;
                }
                else{
                    if (get((K)currentNode.value.key) == null)
                    {
                        currentNode = null;
                        currentIndex = 0;
                        return hasNext();
                    }
                    else{
                        HashMap.Bucket.Node node = currentNode;
                        currentIndex = calculateBucketIndex((K)node.value.key);
                        if (node.next != null){
                            currentNode = node.next;
                            return true;
                        }
                        for (int i = ++currentIndex; i < buckets.length; i++){
                            if (buckets[i] != null && buckets[i].head != null){
                                currentIndex = i;
                                currentNode = buckets[i].head;
                                return true;
                            }
                        }
                        currentNode = null;
                        currentIndex = 0;
                        return false;
                    }
                }
            }

            @Override
            public Entity next() {
                if (currentNode == null){
                    for (int i = 0; i < buckets.length; i++)
                        if (buckets[i] != null && buckets[i].head != null){
                            currentIndex = i;
                            currentNode = buckets[i].head;
                            return currentNode.value;
                        }
                    return null;
                }
                else if (get((K)currentNode.value.key) == null){
                    currentNode = null;
                    currentIndex = 0;
                    return null;
                }
                else
                    return currentNode.value;
            }
        }
//        И вот теперь можно протестировать перебор всех элементов коллекции HashMap:

                for (HashMap.Entity entity: hashMap1) {
            System.out.println(entity);
        }
//        Основной плюс подобного подхода, в рамках перечисления, через Entity, вы получаете доступ к ключу и значению очередного элемента.

//                Оксана, ничего страшного что задание оказалось сложное, понимание и навыки придут со временем, присылайте ваше решение через StringBuilder, я его приму без проблем.
}
