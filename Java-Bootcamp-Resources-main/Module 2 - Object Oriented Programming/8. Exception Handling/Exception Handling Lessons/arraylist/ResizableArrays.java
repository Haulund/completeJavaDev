import java.util.ArrayList;

public class ResizableArrays {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("joe");
        names.add("jim");
        names.add("john");

        
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.set(0, "joe Fresh");
        names.set(3, "katie");
        names.remove(2);
        names.clear();
    }
}
