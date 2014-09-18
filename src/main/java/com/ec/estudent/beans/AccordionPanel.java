/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author Bruxx
 */

@ManagedBean
@SessionScoped
public class AccordionPanel {
	private String messageOne = "Hello JavaBeat One";
	private String messageTwo = "Hello JavaBeat Two";
	private String messageThree = "Hello JavaBeat Three";
	
	public String getMessageOne() {
		System.out.println("Message One Loaded");
		return messageOne;
	}
	public void setMessageOne(String messageOne) {
		this.messageOne = messageOne;
	}
	public String getMessageTwo() {
		System.out.println("Message Two Loaded");
		return messageTwo;
	}
	public void setMessageTwo(String messageTwo) {
		this.messageTwo = messageTwo;
	}
	public String getMessageThree() {
		System.out.println("Message Three Loaded");
		return messageThree;
	}
	public void setMessageThree(String messageThree) {
		this.messageThree = messageThree;
	}
	public void changeListener(TabChangeEvent e){
		System.out.println("TabChangeEvent Has Fired By ::"+e.getSource());
		System.out.println("The next Tab Title is :: "+e.getTab().getTitle());
	}
	
}
