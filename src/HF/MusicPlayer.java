package HF;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


public class MusicPlayer {

    static JFrame frame = new JFrame("Music clip");
    static MyDrawPanel drawPanel;

    public static void main(String args[]) {
        MusicPlayer mp = new MusicPlayer();
        mp.play();
    }

    public void setUpGui() {
        drawPanel = new MyDrawPanel();
        frame.setContentPane(drawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end of setUpGui

    public void play() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // MIDI synthesizer
            sequencer.open();
            sequencer.addControllerEventListener(drawPanel, new int[] { 127 }); // register for event with the sequencer
            // an int array representing the list of
            // ControllerEvents
            Sequence seq = new Sequence(Sequence.PPQ, 4); // create sequence and track
            Track track = seq.createTrack();

            int rand = 0;
            for (int i = 0; i < 150; i += 3) {
                rand = (int) ((Math.random() * 70) + 1);
                track.add(makeEvent(144, 6, rand, 70, i)); // 144 - message type // 6 -channel // rand - note to play //
                // 70 - velocity // i - tempo
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, rand, 100, i + 2));
            } // end of for

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120); // Setting tempo
        } catch (Exception ex) {
            ex.printStackTrace();
        } // end of catch
    } // end of play

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {

            ShortMessage sm = new ShortMessage();
            sm.setMessage(comd, chan, one, two);
            event = new MidiEvent(sm, tick);
        } catch (Exception e) {
        }
        return event;
    } // end of MidiEvent

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {

                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int height = (int) ((Math.random() * 230) + 10);
                int width = (int) ((Math.random() * 230) + 10);

                int x = (int) ((Math.random() * 90) + 10);
                int y = (int) ((Math.random() * 90) + 10);

                g.fillRect(x, y, width, height);
                msg = false;

            } // end of if
        } // end of paintComponent
    } // end of MyDrawPanel
} // end of HF.MusicPlayer