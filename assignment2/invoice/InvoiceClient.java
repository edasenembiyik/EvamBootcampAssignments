package invoice;

import exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface InvoiceClient{

    public Response display(int billType,String memberCode) ;
//    public Response display(int billType,String memberCode, String phoneNum);
    public Response payment(int billType, String memberCode, BigDecimal amount, LocalDate paymentDate) throws InsufficientBalanceException;
    public Response paymentCancel(int billType, String memberCode, BigDecimal amount, LocalDate paymentDate) throws InsufficientBalanceException;
}
