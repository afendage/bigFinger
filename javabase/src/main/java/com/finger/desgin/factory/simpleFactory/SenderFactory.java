package com.finger.desgin.factory.simpleFactory;

public class SenderFactory {

    /**
     * 传参判断模式
     * @param type
     * @return
     */
    public Sender produce(String type){
        if(type.equals("email")){
            return new MailSender();
        }else if(type.equals("sms")){
            return new SmsSender();
        }
        return null;
    }

    // 多方法模式
    public Sender produceEmail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }

    // 静态-多方法模式
    public static Sender produceEmail1(){
        return new MailSender();
    }
}
