package boardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board/")
public class BoardController {

//	@RequestMapping("/boardtest")
//	@ResponseBody
//	public String test() {
//		return "boardcontroller test";
//	}

	// localhost:8080/board/board
	@RequestMapping("board")
	public String board() {
		return "index";
	}

}
