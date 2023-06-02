import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactsList = new SingleLinkList<>();

        contactsList.addToEnd(new Contact(1,  "Лавров Анатолий Павлович", "+89042134323"));
        contactsList.addToEnd(new Contact(2,  "Лаврова Галина Павловна", "+89046784365"));
        contactsList.addToEnd(new Contact(3,  "Чеусов Михайл Геннадьевич", "+89049875665"));
        contactsList.addToEnd(new Contact(4,  "Мичурин Сергей Иванович", "+89040000123"));
        contactsList.addToEnd(new Contact(5,  "Попов Василий Петрович", "+89049876543"));

        for(Contact contact: contactsList){
            System.out.println(contact);
        }


        contactsList.reverse();

        System.out.println("------------------------");

        for(Contact contact: contactsList){
            System.out.println(contact);
        }
    }


    static class Contact {

        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone){
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString(){
            return "Contact: " +
                    "id" + id +
                    ": name='" + name + '\'' +
                    "- phone'" + phone + '\'' +
                    "}";
        }
    }
    public static class SingleLinkList<T> implements Iterable<T> {

        ListItem<T> head;
        ListItem<T>tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;


                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T>{
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty(){
            return head == null;
        }
        public void addToEnd(T item){
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()){
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> curent = head.next;
                head.next = null;
                while (curent != null) {
                    ListItem<T> next= curent.next;
                    curent.next = head;
                    head = curent;
                    curent = next;
                }
            }
        }
    }
}