package dataDrivenTesting;

public class GenerateAlphaNumericRandomVAlue {
public static void main(String[] args) {
	int n=15;//for alphanumeric length
	//chooses the charactes up to menctioned length from given string
	String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789abcdefghgijklmnopqrstuvwxyz";
	//create String builder class for alphanumeric
	StringBuilder s=new StringBuilder(n);
	for (int i = 0; i < n; i++) {
		//generate a random number between 0 to charecters variable length 
		int alphanum = (int)(characters.length()*Math.random());
	//add character one by one inthe end of sringbuilder data
		s.append(characters.charAt(alphanum));
	}
	System.out.println(s);
}
}
