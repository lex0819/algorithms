package ru.geekbrains.lesson4;



public class Program {

    public static void main(String[] args) {

        HashMap<String, String> hashMapGb = new HashMap<>(4);

        String res = hashMapGb.put("+79005554433", "Андрей");
        res = hashMapGb.put("+79005554432", "Алексей");
        res = hashMapGb.put("+79005554432", "Дарья1");
        res = hashMapGb.put("+79005554433", "Дарья2");
        res = hashMapGb.put("+79005554434", "Дарья3");
        res = hashMapGb.put("+79005554435", "Дарья4");
        res = hashMapGb.put("+79005554436", "Дарья5");
        res = hashMapGb.put("+79005554437", "Дарья6");
        res = hashMapGb.put("+79005554438", "Дарья7");
        res = hashMapGb.put("+79005554439", "Дарья8");


        res = hashMapGb.get("+79005554436");

        hashMapGb.remove("+79005554438");

//        for (HashMap.Entity element : hashMap) {
//
//            System.out.println(element.key + " - " + element.value);
//        }

//        System.out.println("Length of buckets is " +hashMapGb.allSize());

//        hashMapGb.testLexHashMap();//testing how it works


        System.out.println(hashMapGb);

    }

}


