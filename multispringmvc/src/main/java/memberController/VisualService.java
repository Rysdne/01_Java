package memberController;

import org.springframework.stereotype.Service;

// 이건 @Bean으로 해도 된다고 함
@Service
public class VisualService {

	public String name() {
		return "hong";
	}

}
