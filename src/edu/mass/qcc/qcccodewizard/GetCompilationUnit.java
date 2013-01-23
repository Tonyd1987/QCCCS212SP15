
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

//~--- non-JDK imports --------------------------------------------------------

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.modules.editor.NbEditorUtilities;

import org.openide.filesystems.FileUtil;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Ian
 * Gets a compilation unit (a parsed tree version of the currently
 * open java source.
 */
public class GetCompilationUnit {
    public CompilationUnit getCU() throws FileNotFoundException, IOException {
        java.io.File currentFile =
            FileUtil.toFile(NbEditorUtilities.getFileObject(EditorRegistry.lastFocusedComponent().getDocument()));
        InputStream     in = null;
        CompilationUnit cu = null;

        try {
            System.out.println("Opening Document Stream");
            in = new FileInputStream(currentFile);
            cu = JavaParser.parse(in);
            System.out.println("Begin Line: " + cu.getBeginLine());
        } catch (ParseException x) {
            System.out.println("Unable to parse the document.");
        } finally {
            in.close();
        }

        return cu;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
