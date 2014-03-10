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

package reader.predicate.impl;

import reader.predicate.Predicate;

import javax.xml.stream.XMLStreamReader;

/**
 * Predicate if name of actual element in stream equals searched.
 */

public class TagNamePredicate implements Predicate<XMLStreamReader> {
    private final String tagname;

    public TagNamePredicate() {
        this("");
    }

    public TagNamePredicate(final String tagname) {
        this.tagname = tagname;
    }

    public boolean apply(XMLStreamReader obj) {
        return obj.isStartElement() && tagname.equals(obj.getLocalName());
    }
}
