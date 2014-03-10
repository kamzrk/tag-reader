/*
* Copyright 2014 - Kamil Zurek
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package reader.filter.tag;

import reader.filter.AbstractFilter;
import reader.predicate.Predicate;

import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;

/**
 * Filter stream according to collection of predicates.
 */
public class TagFilter extends AbstractFilter<XMLStreamReader, Boolean> {

    public Boolean filter(XMLStreamReader reader) {
        boolean passAllPredicates = true;

        if (predicates.size() == 0)
            return Boolean.FALSE;

        for (Predicate<XMLStreamReader> predicate : predicates) {
            passAllPredicates = passAllPredicates && predicate.apply(reader);
            if (!passAllPredicates)
                return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
