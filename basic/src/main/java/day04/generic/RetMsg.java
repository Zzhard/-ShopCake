package day04.generic;

/**
 * @Author zhaoxg
 * @Date 2020/5/6 22:16
 */
public class RetMsg<T> {

    private int errorCode;
    private String errorMsg;
    private T data;
    private static final int SUCCESS_CODE=2000;
    private static final String SUCCESS_MSG="success";

    public RetMsg(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //静态定义，工厂方法，包装数据类
    public static<R> RetMsg<R> builSuccessMsg(R data){
        return new RetMsg<>(SUCCESS_CODE,SUCCESS_MSG,data);
    }
}
