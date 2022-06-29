package member;

public class MemberAccountService {

    private MemberAccount memberAccount;

   public MemberAccount create(MemberAccount memberAccount){
       System.out.println("Customer added.");
       this.memberAccount = memberAccount;
       return null;
   }
    public MemberAccount read(){
        System.out.println("Customer information has been brought.");
        return this.memberAccount;
    }
    public MemberAccount update(MemberAccount memberAccount){
        System.out.println("Customer information has been updated.");
        this.memberAccount = memberAccount;
        return this.memberAccount;
    }
    public void delete(){
        System.out.println("The client has been deleted from the system.");
        this.memberAccount=null;
    }


}
