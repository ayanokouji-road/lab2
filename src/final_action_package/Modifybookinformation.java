package final_action_package;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.HashMap;

public class Modifybookinformation
{
    private Integer isbn;

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String execute()
    {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("isbn", this.isbn);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.push(map);
        return "success";
    }
}

