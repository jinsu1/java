    class MyBook {
        String title;
        int pages;
        String author;

        MyBook()  {
            System.out.println("-----생성자가 실행되었습니다.-----");
            title = "자바 교과서";
            pages = 400;
            author = "자바 강사";
        }
    }

    public class Ex01_SimpleConstructor {

        public static void main(String[] args) {
            MyBook myBook = new MyBook();

            System.out.println(myBook.title);
            System.out.println(myBook.pages);
            System.out.println(myBook.author);
        }
    }

