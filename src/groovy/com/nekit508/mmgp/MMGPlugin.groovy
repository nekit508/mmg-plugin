package com.nekit508.mmgp

import org.gradle.api.Plugin
import org.gradle.api.Project

class MMGPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.taks("init") {
            println("Initt")
        }
    }
}
