
/**
 * Luis Oliver Juarez
 * BallWorld
 */
public class BallRunner
{
    BallWorld ballWorld;
    TGPoint entrancePoint;
    BallBot ballBotArray[];

    private double heading;

    public BallRunner(BallWorld ballWorld1, TGPoint entrancePoint1, int ballBotArrayLength)
    {

        ballWorld = ballWorld1;
        entrancePoint = entrancePoint1;
        ballBotArray = new BallBot[ballBotArrayLength];

    }

    public  void activity1(){
        int x = 0;
        BallWorld ballWorld1 = new BallWorld(200, 200);
        TGPoint tgPoint1 = new TGPoint(0,0);
        BallBot ballBot1 = new BallBot(ballWorld1, tgPoint1, 0, 25);
        while(x==0){
            if(ballBot1.canMoveForward(ballWorld1) == true){
                ballBot1.moveForward();
            }
            else{
                ballBot1.setHeading((ballBot1.getHeading()%360)+90);
            }
        }
    }

    public int findFreeBallBotIndex(){
        int ret = 0;
        for(int i = 0; i < ballBotArray.length; i++){
            if(ballBotArray[i] == null){
                return i;
            }

        }
        return ballBotArray.length;
    }    

    public static void run(){
        int x = 0;
        int freeBallBotIndex;
        boolean clearPoint;
        BallWorld ballWorld = new BallWorld(500, 500);
        TGPoint entrancePoint = new TGPoint(0,0);
        BallRunner ballRunner = new BallRunner(ballWorld, entrancePoint, 12);
        while(x==0){
            freeBallBotIndex = ballRunner.findFreeBallBotIndex();
            clearPoint = ballRunner.entranceClear();
            if(clearPoint){
                if(freeBallBotIndex < ballRunner.ballBotArray.length){
                    ballRunner.ballBotArray[freeBallBotIndex] = new BallBot(ballWorld, entrancePoint, Math.random()*360, 30); 
                }
            }

            for(int i = 0; i < ballRunner.ballBotArray.length; i++){
                BallBot ballBot1 = ballRunner.ballBotArray[i];  
                if(ballRunner.ballBotArray[i] != null) {
                    if(ballBot1.canMoveForward(ballWorld) == true){
                        ballBot1.moveForward();
                    }
                    else{
                        ballBot1.setHeading((Math.random()*360));
                    }
                }
            }
        }

           
    }

    public double distanceBetweenPoints(TGPoint point1,TGPoint point2){
        double result = Math.sqrt((point1.x-point2.x)*(point1.x-point2.x)+(point1.y-point2.y)*(point1.y-point2.y));
        return result;
    }

    public boolean entranceClear(){
        double d = 0;
        for(int i = 0; i < ballBotArray.length; i++){
            if(ballBotArray[i] != null){
                d = distanceBetweenPoints(entrancePoint, ballBotArray[i].getPoint());
                if(d < 2 * ballBotArray[i].getRadius()){
                    return false;
                }
            }

        }
        return true;   

    }
    
    public BallBot ballBotToBounceOff(BallBot ballBot){
    
    }
}