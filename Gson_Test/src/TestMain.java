
public class TestMain{

public static void main(String[] args)
    {
	String json;
	Object obj;
	String className = "Student";

	NewGson gson = new NewGson();
	
	json = gson.toJson(new Student());
	System.out.println(json);

	//After unmarshalling , you can use obj 
	obj = gson.fromJson(json, className);

    }
}