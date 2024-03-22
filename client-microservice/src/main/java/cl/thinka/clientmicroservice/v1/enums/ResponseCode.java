package cl.thinka.clientmicroservice.v1.enums;

import java.util.HashMap;


public enum ResponseCode {

    SUCCESSFUL(0),
    CREATED(1),
    UPDATED(2),
    REMOVED(3),
    NOT_DATA_FOUND(-1),
    PRECONDITION_REQUIRED(-2),
    GENERAL_ERROR(-3);

    private final Integer codError;

    ResponseCode(Integer codError) {
        this.codError = codError;
    }

    public Integer getCodError() {
        return this.codError;
    }

    private static final HashMap<Integer, String> codeDescription = new HashMap<Integer, String>() {
        {
            put(0, "successful");
            put(1, "created");
            put(2, "updated");
            put(3, "removed");
            put(-1, "not data found");
            put(-2, "precondition required");
            put(-3, "general error");
        }
    };
    public String getDescError(){
        return codeDescription.get(this.codError);
    }

    public static ResponseCode getByCode(int codError) {
        for(ResponseCode e : values()) {
            if(e.codError==codError){
                return e;
            }
        }
        return null;
    }
}
