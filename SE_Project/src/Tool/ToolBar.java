package Tool;

public class ToolBar {          //contesto 
    private Tool currentState;
    
    public void setCurrentState(Tool state){
        this.currentState =  state ;
    }

    public Tool getCurrentState() {
        return currentState;
    }
    
    
}
