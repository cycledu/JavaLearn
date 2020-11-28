package ThinkingInJava.Charpter17.practise8;

/**
 * @Author : jingtao
 * @Data : 2020/05/16/21:37
 * @Description :
 * @Page or WebSite：P477/练习8
 * @Expected result ：
 */
public class SList<T> {
    int no;
    T content;
    SList next;
    public SList(int no, T content, SList next) {
        this.no = no;
        this.content = content;
        this.next = next;
    }
    public SListIterator<T> sListIterator() {
        return new SListIterator<T>();
    }
    public class SListIterator<T> {
        int index;
        public SListIterator() {
            this.index = SList.this.no;
        }
        public void add(String s) {
            int newNo = no + 1;
            SList<String> stringSList = new SList<>(newNo, s, null);
            SList.this.next = stringSList;
        }
        public void remove() {
            while (hasNext()) {
                if (SList.this.no == 1 && SList.this.next != null) {


                    //SList.this=SList.this.sListIterator().next() ;
                    break;
                } else if (SList.this.next.next != null) {
                    SList.this.next = SList.this.next.next;
                } else if (SList.this.next.next == null) {
                    System.out.println("index已经移动到最后");
                    next = null;
                    break;
                }
            }
        }
        public void next() {
            if (hasNext()) {
                index++;
            }else {
                System.out.println("已经移动到了尾部");
            }
        }
        //        public int nextIndex() {
//            return SList.this.no;
//        }
        public boolean hasNext() {
            return SList.this.next != null;
        }
    }
    @Override
    public String toString() {
        return "no=" + no + ", content=" + content + ", ->" + next;
    }
}
