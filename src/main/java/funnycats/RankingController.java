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

import java.util.Comparator;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
@Controller
@RequestMapping(value="/ranking")
public class RankingController {

	@RequestMapping(method=RequestMethod.GET)
	public String getRanking(Model model) {
		Comparator<Long> comparator = new ValueComparator();
		TreeMap<Long, FunnyCat> orderedMap = new TreeMap<Long, FunnyCat>(comparator);
		orderedMap.putAll(CatController.cats);
		model.addAttribute("cats", orderedMap);
		return "ranking";
	}
	
	@RequestMapping(value="{catId}/{value}", method=RequestMethod.GET)
	public String vote(@PathVariable(value="catId") Long catId, @PathVariable(value="value") Integer value, Model model) {
		FunnyCat cat = CatController.cats.get(catId);
		cat.addVote(value);
		return "redirect:/cats/" + catId;
	}
	
	class ValueComparator implements Comparator<Long> {

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Long arg0, Long arg1) {
			return CatController.cats.get(arg0).getRating().compareTo(CatController.cats.get(arg1).getRating());
		}
		
	}
	
}
