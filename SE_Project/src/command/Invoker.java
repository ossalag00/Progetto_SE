/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.util.Stack;

/**
 *
 * @author giorgino
 */
public class Invoker {
    private Command command;
    private Stack<Command> listCommand = new Stack<>();
    
    
    public void setCommand(Command command){
        this.command=command;
    }
    
    public void executeCommand(){
        this.command.execute();
        
    }
    
    public void push(Command command){
        listCommand.push(command);
    }
    
    public Command pop(){
        return listCommand.pop();
    }
}
