/*
 * #%L
 * ACS AEM Commons Bundle
 * %%
 * Copyright (C) 2013 Adobe
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package com.adobe.acs.commons.workflow.bulk.removal;

import org.apache.sling.api.resource.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class WorkflowInstanceFolderComparatorTest {

    @Test
    public void testCompare() throws Exception {

        Resource one = mock(Resource.class);
        Resource two = mock(Resource.class);
        Resource three = mock(Resource.class);
        Resource four = mock(Resource.class);
        Resource five = mock(Resource.class);

        when(one.getName()).thenReturn("2009_09_02_0");
        when(two.getName()).thenReturn("2012_01_12_3");
        when(three.getName()).thenReturn("2014_01_02_1");
        when(four.getName()).thenReturn("2014_06_06_1");
        when(five.getName()).thenReturn("2014_06_06_2");

        List<Resource> actual = new ArrayList<Resource>();

        actual.add(four);
        actual.add(five);
        actual.add(one);
        actual.add(three);
        actual.add(two);

        Collections.sort(actual, new WorkflowInstanceFolderComparator());

        assertEquals(actual.get(0).getName(), one.getName());
        assertEquals(actual.get(1).getName(), two.getName());
        assertEquals(actual.get(2).getName(), three.getName());
        assertEquals(actual.get(3).getName(), four.getName());
        assertEquals(actual.get(4).getName(), five.getName());




    }
}