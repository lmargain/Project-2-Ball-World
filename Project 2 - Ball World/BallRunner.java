
/**
 * Luis Oliver Juarez
 * BallWorld
 */
public class BallRunner
{
    BallWorld ballWorld;
    TGPoint entrancePoint;
    BallBot[] ballBotArray;
   public BallRunner(BallWorld ballWorld, TGPoint entrancePoint, int ballBotArrayLength){
       this.ballWorld = ballWorld;
       this.entrancePoint = entrancePoint;
       ballBotArray = new BallBot[ballBotArrayLength];
    }
   public int findFreeBallBotIndex(){
        for(int i = 0; i < ballBotArray.length; i++){
            if(ballBotArray[i]==null)return i;
        }
        return ballBotArray.length;
    }
   public static void activity1 (){
       BallWorld ballWorld = new BallWorld (200, 200);
       TGPoint tgPoint = new TGPoint (0,0);
       BallBot ballBot = new BallBot (ballWorld, tgPoint, 90.0, 30);
       while(true){
           if(ballBot.canMoveForward(ballWorld)) ballBot.moveForward();
           else ballBot.setHeading((ballBot.getHeading()+90)%360);
        }
     }
}