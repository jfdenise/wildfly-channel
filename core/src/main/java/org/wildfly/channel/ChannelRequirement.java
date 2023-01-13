/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.channel;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Java representation of a Channel requirement identified by Maven coordinates.
 */
public class ChannelRequirement {

    private final String groupId;
    private final String artifactId;
    private final String version;

    /**
     * Representation of a channel requirement.
     *
     * @param groupId groupId of the Maven coordinate - required
     * @param artifactId artifactId of the Maven coordinate - required
     * @param version version of the Maven coordinate - can be {@code null}
    */
    @JsonCreator
    public ChannelRequirement(@JsonProperty(value = "groupId", required = true) String groupId,
                       @JsonProperty(value = "artifactId", required = true) String artifactId,
                       @JsonProperty(value = "version") String version) {
        requireNonNull(groupId);
        requireNonNull(artifactId);

        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    @JsonInclude(NON_NULL)
    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "ChannelRequirement{" +
                "groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
