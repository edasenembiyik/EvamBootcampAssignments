import invoice.InvoiceClient;
import invoice.InvoiceService;
import member.MemberAccount;
import member.MemberAccountService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MemberAccount customer1 = new MemberAccount(2529, "Eda", "Biyik", BigDecimal.valueOf(1290.0), "05300000000000");
        MemberAccountService memberAccountService = new MemberAccountService();
        memberAccountService.create(customer1);
        InvoiceClient invoiceClient = new InvoiceService(memberAccountService);
//        invoiceClient.display();
        StringBuilder str1 = new StringBuilder("İlk String");
        StringBuilder str2 = new StringBuilder("İkinci String");
        StringBuilder str3 = new StringBuilder("Üçüncü String");
        str3=str2;
        str2 = str1;
        System.out.println(str1 + " " + str2 + " " + str3);

        String name=" E da S ene m";
        System.out.println(name.replace(" ",""));
    }
}