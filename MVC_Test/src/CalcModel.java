import java.math.BigInteger;


public class CalcModel {
	
	private float result;
	
	public CalcModel(){
	}
	
	public void add(float operand, float operand2) {
		result = operand + operand2;
	}
	
	public void subtract(float operand, float operand2) {
		result = operand - operand2;
	}
	
	public void multiply(float operand, float operand2) {
		result = operand * operand2;
	}
	
	public void divide(float operand, float operand2) {
		result = operand / operand2;
	}
	
	public void setValue(float value) {
		result = value;
	}
	
	public float getValue() {
		return result;
	}

}
