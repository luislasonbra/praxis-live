/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DebugEditorPanel.java
 *
 * Created on 29-Apr-2011, 10:45:48
 */
package net.neilcsmith.praxis.live.pxr;

import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import net.neilcsmith.praxis.core.Argument;
import net.neilcsmith.praxis.core.CallArguments;
import net.neilcsmith.praxis.live.core.api.Callback;
import static net.neilcsmith.praxis.live.pxr.PXRParser.*;
import org.openide.util.Exceptions;
import org.openide.util.RequestProcessor;

/**
 *
 * @author Neil C Smith (http://neilcsmith.net)
 */
class DebugEditorPanel extends javax.swing.JPanel {

    private final static Logger LOG = Logger.getLogger(DebugEditorPanel.class.getName());
    private static final RequestProcessor RP = new RequestProcessor();
    private PXRDataObject dob;

    /** Creates new form DebugEditorPanel */
    public DebugEditorPanel(PXRDataObject dob) {
        initComponents();
        this.dob = dob;
        structure.setText("Loading ... " + dob.getPrimaryFile().getPath());
        RP.execute(new FileParser());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        structure = new javax.swing.JTextArea();

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        structure.setColumns(20);
        structure.setEditable(false);
        structure.setRows(5);
        jScrollPane1.setViewportView(structure);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea structure;
    // End of variables declaration//GEN-END:variables

    private class FileParser implements Runnable {

        @Override
        public void run() {
            try {
                String script = dob.getPrimaryFile().asText();
                final RootElement root = PXRParser.parse(script);
                final String overview = buildString(root);
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        structure.setText(overview);
//                        build(root);
                    }
                });
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
//
//        private void build(RootElement root) {
//            PXRBuilder.getBuilder(null, dob.getPrimaryFile(), root).process(new Callback() {
//
//                @Override
//                public void onReturn(CallArguments args) {
//                    LOG.info("Successfully built file.");
//                }
//
//                @Override
//                public void onError(CallArguments args) {
//                    LOG.info("Error building file.");
//                }
//            });
//        }

        private String buildString(RootElement root) {
            StringBuilder builder = new StringBuilder();
            builder.append("FILE STRUCTURE : ").append(dob.getPrimaryFile().getPath()).append("\n\n");
            writeComponent(builder, root, 0);
            return builder.toString();
        }

        private void writeComponent(StringBuilder builder, ComponentElement cmp, int level) {
            indent(builder, level);
            builder.append(level == 0 ? "ROOT: " : "CMP: ").append(cmp.address).append(' ').append(cmp.type).append('\n');
            for (AttributeElement attr : cmp.attributes) {
                indent(builder, level + 1);
                writeAttribute(builder, attr);
            }
            for (PropertyElement prop : cmp.properties) {
                indent(builder, level + 1);
                writeProperty(builder, prop);
            }
            for (ComponentElement child : cmp.children) {
                writeComponent(builder, child, level + 1);
            }
            for (ConnectionElement con : cmp.connections) {
                indent(builder, level + 1);
                writeConnection(builder, con);
            }
        }

        private void writeAttribute(StringBuilder builder, AttributeElement attr) {
            builder.append("ATTR: ").append(attr.key).append(" : ").append(attr.value).append('\n');
        }

        private void writeProperty(StringBuilder builder, PropertyElement prop) {
            builder.append("PROP: ").append(prop.property);
            for (Argument arg : prop.args) {
                builder.append(' ').append(arg);
            }
            builder.append('\n');
        }

        private void writeConnection(StringBuilder builder, ConnectionElement con) {
            builder.append("CON: ").append(con.port1).append(" ~ ").append(con.port2);
            builder.append('\n');
        }

        private void indent(StringBuilder builder, int level) {
            for (int i = 0; i < level; i++) {
                builder.append("  ");
            }
        }
    }
}