package invoice;

import java.time.LocalDate;

public class Response {
    private String code;
    private LocalDate date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Response(String code, LocalDate date) {
        this.code = code;
        this.date = date;
    }
}
