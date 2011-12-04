/*
 * The MIT License
 *
 * Copyright (c) <2011> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package funnycats;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
@Controller
@RequestMapping(value="/cats")
public class CatController {

	// FIXME: Err, that's only for the demo application. Don't do this in real applications :)
	public static final Map<Long, FunnyCat> cats = new ConcurrentHashMap<Long, FunnyCat>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCats(Model model) {
		model.addAttribute(new FunnyCat());
		return "cats/main";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String rate(FunnyCat cat, BindingResult result) {
		if (result.hasErrors()) {
			return "cats/main";
		}
		// TBD: access as static variable
		this.cats.put(cat.getId(), cat);
		return "redirect:/cats/view/" + cat.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		FunnyCat cat = this.cats.get(id);
		if (cat == null) {
			throw new RuntimeException("Funny cat went somewhere... look for his ID: "+id);
		}
		model.addAttribute("cat", cat);
		Long next = cat.getId() + 1;
		if( this.cats.get(next) != null ) {
			model.addAttribute("next", next);
		} else {
			model.addAttribute("next", Long.valueOf(1));
		}
		return "cats/view";
	}

}

