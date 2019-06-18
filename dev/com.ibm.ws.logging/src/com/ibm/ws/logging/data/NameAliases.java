/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.logging.data;

import java.util.Map;

public class NameAliases {

    private final String[] originalNames;
    private volatile String[] aliases;

    public NameAliases(String[] originalNames) {
        this.originalNames = originalNames;
    }

    public void newAliases(Map<String, String> newAliases) {
        aliases = originalNames.clone();
        for (Map.Entry<String, String> entry : newAliases.entrySet()) {
            for (int i = 0; i < originalNames.length; i++) {
                if (originalNames[i].equals(entry.getKey().trim())) {
                    aliases[i] = entry.getValue().trim();
                }
            }
        }
    }

    public String getAlias(int index) {
        return aliases[index];
    }
}
