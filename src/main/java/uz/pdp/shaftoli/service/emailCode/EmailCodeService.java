package uz.pdp.shaftoli.service.emailCode;

public interface EmailCodeService {

    String sendCodeToEmailAndReturn(String receiverEmail);
}