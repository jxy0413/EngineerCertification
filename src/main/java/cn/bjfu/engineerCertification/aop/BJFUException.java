package cn.bjfu.engineerCertification.aop;

/**
 * Created by jxy on 2021/4/19 0019 16:58
 */
public class BJFUException extends Exception {
    /*无参构造函数*/
    public BJFUException(){
        super();
    }

    //用详细信息指定一个异常
    public BJFUException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public BJFUException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public BJFUException(Throwable cause) {
        super(cause);
    }
}
