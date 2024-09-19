public class arr_quiz9 {
    public static void main(String[] args) {
        String[] chul ={ "1", "5", "7", "J", "Q", "A" };
        String[] young ={ "2", "3", "4", "5", "Q", "K", "A" };
        int count = 0;
        String[] anwser = new String[3];

        for(int i=0; i<young.length; i++) {
            for(int j=0; j<chul.length; j++) {
                if( young[i].equals(chul[j]) ) {
                    anwser[count] = j + "번째 >> " + chul[j] + "\n";
                    count++;
                }
            }
        }
        System.out.printf("가져올 수 있는 카드의 수: %d장\n", count);
        for (int i=0; i<anwser.length; i++) {
            System.out.print(anwser[i]);
        }
    }
}
