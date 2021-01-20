package factorybean;

/*
private 생성자를 가진 이 클래스는 빈으로 등록해서 사용할 수 없다.
하지만 스프링은 리플랙션을 이용해서 private 생성자를 가진 클래스도 빈으로 등록하면 오브젝트가 만들어지나
이렇게 사용하지 말라고 붙여진 private 접근자임으로 강제로 생성하지 않는다.
 */
public class Message {
    String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }
}
