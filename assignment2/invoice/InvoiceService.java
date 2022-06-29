package invoice;

import exception.InsufficientBalanceException;
import member.MemberAccount;
import member.MemberAccountService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceService implements InvoiceClient {

    private final MemberAccountService memberAccountService;

    public InvoiceService(MemberAccountService memberAccountService) {
        this.memberAccountService = memberAccountService;
    }


    @Override
    public Response display(int billType, String memberCode) {
        if(billType == 1){
            String code = memberCode.substring(0,memberCode.length()-10);
            String phone = memberCode.substring(code.length());
            display(billType,code,phone);
            return new Response("1",LocalDate.now());
        } else if(billType ==2) {
            System.out.println("Bu bir internet faturasıdır");
            return new Response("1",LocalDate.now());

        } else if(billType ==3){
            System.out.println("Bu bir su faturasıdır");
            return new Response("1",LocalDate.now());

        } else {
            return new Response("0",LocalDate.now());
        }
    }

    public Response display(int billType, String memberCode, String phoneNum) {
        System.out.println("Bu bir telefon faturasıdır");

        return new Response("1",LocalDate.now());
    }

    @Override
    public Response payment(int billType, String memberCode, BigDecimal amount, LocalDate paymentDate) throws InsufficientBalanceException {
        MemberAccount memberAccount = memberAccountService.read();
        BigDecimal balance = memberAccount.getBalance();
        if (balance.compareTo(amount) == -1) {
            throw new InsufficientBalanceException("bakiye yetersizdir");
        }
        if (memberAccount.getMemberCode().equals(memberCode)) {
            memberAccount.setBalance(balance.subtract(amount));
            memberAccountService.update(memberAccount);
            return new Response("0", paymentDate);

        }
        return new Response("1", paymentDate);
    }

    @Override
    public Response paymentCancel(int billType, String memberCode, BigDecimal amount, LocalDate paymentDate) throws InsufficientBalanceException {
        MemberAccount memberAccount = memberAccountService.read();
        BigDecimal balance = memberAccount.getBalance();
        //iptal sırasında userin balance kontrolu olmaması lazım.
        if (memberAccountService.read().getBalance().compareTo(amount) == -1) {
            throw new InsufficientBalanceException("bakiye yetersizdir");
        }
        if (memberAccount.getMemberCode().equals(memberCode)) {
            memberAccount.setBalance(balance.add(amount));
            memberAccountService.update(memberAccount);
            return new Response("0", paymentDate);

        }
        return new Response("1", paymentDate);
    }

}
