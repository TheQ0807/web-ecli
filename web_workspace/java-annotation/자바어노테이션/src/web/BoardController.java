package web;

import java.util.List;

import custom.annotation.Path;

public class BoardController {
	
	@Path("/add.html")
	public void addBoard() {
		
	}
	
	@Path("/list.html")
	public List<?> listBoard(){
		return null;
	}
	
	@Path(value="/delete.html")
	public void deleteBoard(int no){
		
	}
}
