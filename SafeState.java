
/**
 * @author (Callum Fortune)
 * @version (10/12/23)
 */
public class SafeState
{
    private String userCode;
    private String masterCode;
    private String display;
    private boolean open;
    
    public SafeState() {
        
        userCode = null;
        masterCode = "999999";
        display = "WELCOME";
        open = true;
        
    }
    
    public String getDisplay() {
        return display;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public boolean open(String aCode) {
        
        if(open) {
            display = "ALREADY OPEN";
        } else if(aCode == userCode || aCode == masterCode) {
            open = true;
            display = "OPEN";
            userCode = null;
        } else {
            display = "INAVLID CODE";
        }
        
        return open;
    }
    
    public boolean isValidUserCode(String aCode) {
        
        boolean valid = true;
        
        if(aCode.length() != 4) {
            valid = false;
        }
        
        for(int i = 0;i < aCode.length(); i++) {
            if(aCode.charAt(i) < '0' || aCode.charAt(i) > '9') {
                valid = false;
                break;
            }
        }
        
        return valid;
        
    }
    
    public boolean lock(String aCode) {
        
        if(!isOpen()) {
            display = "ALREADY LOCKED";
        } else if(isValidUserCode(aCode)) {
            open = false;
            display = "LOCKED";
            userCode = aCode;
        } else {
            display = "INVALID CODE";
        }
        
        return isOpen() ? false : true;
    }
    
    public String about() {
        return "Safe " + display;
    }
    
}
