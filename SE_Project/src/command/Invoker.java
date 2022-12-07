/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.Stack;


public class Invoker {
    private Command command;
    private Stack<Command> listCommand = new Stack<>();
    
    
    public void setCommand(Command command){
        this.command=command;
    }
    
    public void executeCommand(){
        this.command.execute();
        this.push(command);
    }
    
    private void push(Command command){
        listCommand.push(command);
    }
    
    private Command pop(){
        return listCommand.pop();
    }
    public void undoLast(){
        if(!listCommand.empty()){
            Command c=this.pop();
            c.undo();
        }
        
    }
}
