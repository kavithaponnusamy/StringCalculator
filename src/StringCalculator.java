import java.util.InputMismatchException;

public class StringCalculator {
	public static void main(String[] args) {
		System.out.println(add("1,2,3,4,5,"));
	}
	public static String add(String numbers) {
		if(numbers.isEmpty()) {
				return "0";		
		} else {
		String delimiter=",";//default delimiter is comma.
		
		// For different delimiters:
		if(numbers.startsWith("//")){
			String temp="";
			delimiter=numbers.substring(2,numbers.indexOf("\n"));
			//System.out.println("delimiter"+delimiter);
			numbers=numbers.substring(numbers.indexOf("\n")+1);
			//System.out.println(numbers);
			boolean repeatedDelimiter = true;
			if (delimiter.length()>1) { 
				temp = delimiter.substring(0,1);
				//System.out.println("temp:"+temp);
				for (int i=1;i<delimiter.length();i++) {
					if (!(delimiter.substring(i,i+1).equalsIgnoreCase(temp))) {
						repeatedDelimiter = false;
					}
					//System.out.println(i);
					//System.out.println(repeatedDelimiter);
				}
			}
			//System.out.println(repeatedDelimiter);
			if (!repeatedDelimiter) {
				for (int i=1;i<delimiter.length();i++) {
					String sn = delimiter.substring(i,i+1);
					//System.out.println("sn:"+sn);
					//System.out.println("temp:"+temp);
					numbers = numbers.replace(sn, temp);
					}
				delimiter = temp;
			}

			//System.out.println(delimiter);
			//System.out.println(numbers);
		}
		numbers=numbers.replace("\n",delimiter); //replacing new line character with delimiter.
		delimiter = delimiter.replace("*", "\\*");//adding escape character for *
if (numbers.substring(numbers.length()-1).equalsIgnoreCase(delimiter)) {
	return "Number expected but EOF found.";
}
		String[] number=numbers.split(delimiter);// splitting the values
		//System.out.println("delimiter:"+delimiter);
		int sum=0;
		boolean neg=false;
		String negative="Negatives not allowed: ";
		for(String num : number) {
			//System.out.println("num:"+num);
			if(Integer.parseInt(num)<0) {
				negative+=num+",";
				neg = true;
			}
			if(Integer.parseInt(num)<=1000) {
				sum+=Integer.parseInt(num);
			}
		}
		if (neg) {
			String str= negative.substring(0,negative.length()-1);
			//System.out.println(str);
			//throw new InputMismatchException(str);
			return str;
		}
		return String.valueOf(sum);
		}
	}
}
	
