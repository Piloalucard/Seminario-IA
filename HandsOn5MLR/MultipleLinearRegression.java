

public class MultipleLinearRegression {    
  double b0;
  double b1;
  double b2;
  Dataset dataset;

  public MultipleLinearRegression(Dataset _dataset) {
    this.dataset = _dataset;
    this.Calcular();
  }

  private void Calcular() {
    double[][] data = dataset.getData();
    int n = data.length;

    // Variable position in tuple
    int x1 = 0;
    int x2 = 1;
    int y = 2;

    // Sums
    double sumOfX1 = 0;
    double sumOfX2 = 0;
    double sumOfY = 0;
    double sumOfX1Square = 0;
    double sumOfX2Square = 0;
    double sumOfProductX1Y = 0;
    double sumOfProductX2Y = 0;
    double sumOfProductX1X2 = 0;

    for (int i = 0; i < n; i++) {
      try {
    	  sumOfX1 += data[i][x1];
      }catch (Exception e){
    	  sumOfX1 += 0;
      }
      try {
    	  sumOfX2 += data[i][x2];
      }catch (Exception e){
        sumOfX2 += 0;
      }
      try {
    	  sumOfY += data[i][y];
      }catch (Exception e){
    	  sumOfY += 0;
      }
      try {
        sumOfX1Square += data[i][x1] * data[i][x1];
      }catch (Exception e){
        sumOfX1Square += 0;
      }
      try {
        sumOfX2Square += data[i][x2] * data[i][x2];
      }catch (Exception e){
        sumOfX2Square += 0;
      }
      try {
        sumOfProductX1Y += data[i][x1] * data[i][y];
      }catch (Exception e){
        sumOfProductX1Y += 0;
      }
      try {
        sumOfProductX2Y += data[i][x2] * data[i][y];
      }catch (Exception e){
        sumOfProductX2Y += 0;
      }

      try {
        sumOfProductX1X2 += data[i][x1] * data[i][x2];
      }catch (Exception e){
        sumOfProductX1X2 += 0;
      }

    }

    double[][] linearEquationMatrix = {
      {n,       sumOfX1,          sumOfX2,          sumOfY},
      {sumOfX1, sumOfX1Square,    sumOfProductX1X2, sumOfProductX1Y},
      {sumOfX2, sumOfProductX1X2, sumOfX2Square,    sumOfProductX2Y},
    };
    
    double[] results = MatrixOperations.cramer(linearEquationMatrix);
    this.b0 = results[0];
    this.b1 = results[1];
    this.b2 = results[2];
  }

  public void printEquation() {
    System.out.println("y = " + this.b0 + " + " + this.b1  + "x1" + " + " + this.b2 + "x2");
  }
  
  public void predict(double x1, double x2) {
    double y = this.b0 + (this.b1 * x1) + (this.b2 * x2);
    System.out.println("Prediction:");
    System.out.println("y = " + y);
    System.out.println("x1 = " + x1 );
    System.out.println("x2 = " + x2);
  }
}
