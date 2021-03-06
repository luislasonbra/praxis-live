/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 Neil C Smith.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU General Public License version 3
 * along with this work; if not, see http://www.gnu.org/licenses/
 *
 *
 * Please visit http://neilcsmith.net if you need additional information or
 * have any questions.
 */
package net.neilcsmith.praxis.live.project.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.swing.Action;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.neilcsmith.praxis.live.project.DefaultPraxisProject;
import net.neilcsmith.praxis.live.project.ProjectPropertiesImpl;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.ListView;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author Neil C Smith (http://neilcsmith.net)
 */
class LibrariesCustomizer extends javax.swing.JPanel implements ExplorerManager.Provider {

    private final ExplorerManager manager;
    private final DefaultPraxisProject project;
    private final ProjectPropertiesImpl props;

    private Node root;

    /**
     * Creates new form FilesCustomizer
     */
    LibrariesCustomizer(DefaultPraxisProject project) {
        this.project = Objects.requireNonNull(project);
        props = project.getLookup().lookup(ProjectPropertiesImpl.class);
        FileObject libsFolder = project.getProjectDirectory()
                .getFileObject(DefaultPraxisProject.LIBS_PATH);
        if (libsFolder == null || !libsFolder.isFolder()) {
            root = new AbstractNode(Children.LEAF);
        } else {
            root = new FileNode(DataFolder.findFolder(libsFolder).getNodeDelegate());
        }
        manager = new ExplorerManager();
        manager.setRootContext(root);
        manager.addPropertyChangeListener(new ManagerListener());
        initComponents();
        ((ListView) fileList).setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileList = new ListView();
        importButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        importButton.setText(org.openide.util.NbBundle.getMessage(LibrariesCustomizer.class, "LibrariesCustomizer.importButton.text")); // NOI18N
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        removeButton.setText(org.openide.util.NbBundle.getMessage(LibrariesCustomizer.class, "LibrariesCustomizer.removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileList, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileList, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        FileChooserBuilder fcb = new FileChooserBuilder(LibrariesCustomizer.class); // use project specific String?
        fcb.setFilesOnly(true);
        fcb.setTitle("Import library");
        fcb.setApproveText("Import");
        fcb.forceUseOfDefaultWorkingDirectory(true);
        fcb.setFileFilter(new FileNameExtensionFilter("JAR files", "jar"));
        File add = fcb.showOpenDialog();
        if (add != null) {
            importLibrary(FileUtil.toFileObject(add));
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void importLibrary(FileObject lib) {
        try {
            props.importLibrary(lib);
            if (!(root instanceof FileNode)) {
                FileObject libs = FileUtil.createFolder(project.getProjectDirectory(), DefaultPraxisProject.LIBS_PATH);
                root = new FileNode(DataFolder.findFolder(libs).getNodeDelegate());
                manager.setRootContext(root);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }


    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (project.isActive()) {

        } else {
            try {
                FileObject lib = manager.getSelectedNodes()[0].getLookup().lookup(FileObject.class);
                props.removeLibrary(lib.getNameExt());
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane fileList;
    private javax.swing.JButton importButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }

    private class ManagerListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (ExplorerManager.PROP_SELECTED_NODES.equals(evt.getPropertyName())) {
                if (manager.getSelectedNodes().length > 0) {
                    removeButton.setEnabled(true);
                } else {
                    removeButton.setEnabled(false);
                }

            }
        }
    }

    private class FileNode extends FilterNode {

        FileNode(Node node) {
            super(node, node.isLeaf() ? FilterNode.Children.LEAF : new FileChildren(node));
        }

        @Override
        public Action getPreferredAction() {
            return null;
        }

        @Override
        public Action[] getActions(boolean context) {
            return new Action[0];
        }
    }

    private class FileChildren extends FilterNode.Children {

        public FileChildren(Node node) {
            super(node);
        }

        @Override
        protected Node[] createNodes(Node key) {
            FileObject fo = key.getLookup().lookup(FileObject.class);
            if (fo == null || !fo.isData() || !fo.hasExt("jar")) {
                return new Node[0];
            } else {
                return super.createNodes(key);
            }
        }

    }
}
