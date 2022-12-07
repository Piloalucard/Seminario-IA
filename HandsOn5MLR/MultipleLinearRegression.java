

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

    int x1 = 0;
    int x2 = 1;
    int y = 2;

    double sumX1 = 0;
    double sumX2 = 0;
    double sumY = 0;
    double X1Sq = 0;
    double X2Sq = 0;
    double X1pY = 0;
    double X2pY = 0;
    double X1pX2 = 0;

    for (int i = 0; i < n; i++) {
      try {
    	  sumX1 += data[i][x1];
      }catch (Exception e){
    	  sumX1 += 0;
      }
      try {
    	  sumX2 += data[i][x2];
      }catch (Exception e){
        sumX2 += 0;
      }
      try {
    	  sumY += data[i][y];
      }catch (Exception e){
    	  sumY += 0;
      }
      try {
        X1Sq += data[i][x1] * data[i][x1];
      }catch (Exception e){
        X1Sq += 0;
      }
      try {
        X2Sq += data[i][x2] * data[i][x2];
      }catch (Exception e){
        X2Sq += 0;
      }
      try {
        X1pY += data[i][x1] * data[i][y];
      }catch (Exception e){
        X1pY += 0;
      }
      try {
        X2pY += data[i][x2] * data[i][y];
      }catch (Exception e){
        X2pY += 0;
      }

      try {
        X1pX2 += data[i][x1] * data[i][x2];
      }catch (Exception e){
        X1pX2 += 0;
      }

    }

    double[][] linearEquationMatrix = {
      {n,       sumX1,          sumX2,          sumY},
      {sumX1, X1Sq,    X1pX2, X1pY},
      {sumX2, X1pX2, X2Sq,    X2pY},
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
