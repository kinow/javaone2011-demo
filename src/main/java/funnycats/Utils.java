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

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.functor.UnaryPredicate;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class Utils {

	// A predicate for valid picture names
	private static final UnaryPredicate<String> validPictureName = new UnaryPredicate<String>() {
		
		private final List<String> validExtensions = Arrays.asList(".png", ".jpg", ".jpeg", ".gif");

		public boolean test(String filename) {
			for(String validExtension : validExtensions) {
				if(filename.endsWith(validExtension)) {
					return true;
				}
			}
			return false;
		}
		
	};
	
	private static final FilenameFilter pictureFileNameFilter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			name = name.toLowerCase();
			return validPictureName.test(name);
		}
	};
	
	public static List<FunnyCat> getFunnyCats( final File directory ) {
		final List funnyCats = new ArrayList();
		
		File[] pictures = directory.listFiles(pictureFileNameFilter);
		
		long index = 1;
		for(File picture : pictures) {
			FunnyCat funnyCat = new FunnyCat();
			funnyCat.setId(index);
			funnyCat.setFileName(picture.getName());
			funnyCat.setVotes(0);
			index += 1;
			
			funnyCats.add(funnyCat);
		}
		
		return funnyCats;
	}
	
}
