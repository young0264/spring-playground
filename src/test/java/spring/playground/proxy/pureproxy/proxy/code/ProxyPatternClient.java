package spring.playground.proxy.pureproxy.proxy.code;

/** client 역할 */
public class ProxyPatternClient {

    /**
     * client 는 Subject(서버가 될지 프록시 서버가 될지 모르는 어떠한 객체)
     * interface를 바라보고
     **/
    private Subject subject;
    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }
    public void execute() {
        subject.operation();
    }

}
