
public class StringCalculator {
	public static void main(String[] args) {
		System.out.println(add(""));
		
	}
	public static String add(String numbers) {
		if(numbers.length()>0) {
		String[] number=numbers.split("\n//,");
		double sum=0;
		for(String num : number) {
			sum+=Double.parseDouble(num);
			
		}
		return String.valueOf(sum);
		}
		else
		{
			return "0";		
		}
	}

}
