import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class HotelGUI extends JFrame {


    static final Color BG        = new Color(15,  20,  35);
    static final Color PANEL     = new Color(22,  30,  50);
    static final Color CARD      = new Color(30,  42,  68);
    static final Color ACCENT    = new Color(99, 179, 237);
    static final Color ACCENT2   = new Color(252,176, 69);
    static final Color SUCCESS   = new Color(72, 199,142);
    static final Color DANGER    = new Color(252, 92, 92);
    static final Color TEXT      = new Color(225,235,255);
    static final Color TEXT_DIM  = new Color(120,140,180);
    static final Font  TITLE     = new Font("SansSerif", Font.BOLD,  22);
    static final Font  HEADING   = new Font("SansSerif", Font.BOLD,  15);
    static final Font  BODY      = new Font("SansSerif", Font.PLAIN, 13);
    static final Font  MONO      = new Font("Monospaced",Font.PLAIN, 12);


    ArrayList<Guest>       guests       = new ArrayList<>();
    ArrayList<Room>        rooms        = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ReservationControl     resControl   = new ReservationControl();

    JPanel mainContent;
    JLabel statusBar;

    public HotelGUI() {
        setTitle("Hotel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BG);

        seedData();

        add(buildSidebar(),  BorderLayout.WEST);
        add(buildContent(),  BorderLayout.CENTER);
        add(buildStatusBar(),BorderLayout.SOUTH);

        showDashboard();
        setVisible(true);
    }


    void seedData() {
        try {
            rooms.add(new SingleRoom ("101", 1, 3500,  true, true, true));
            rooms.add(new SingleRoom ("102", 1, 3500,  false,true, false));
            rooms.add(new LuxuryRoom ("201", 2, 8500,  true, true, "King"));
            rooms.add(new LuxuryRoom ("202", 2, 9000,  true, true, "Queen"));
            rooms.add(new DuplexRoom ("301", 3, 15000, 2, true));
            rooms.add(new DuplexRoom ("302", 3, 17000, 3, true));
        } catch (InvalidRoomException e) {
            showError("Room seed error: " + e.getMessage());
        }
        try {
            guests.add(new Vip     (1, "Ahmed Al-Rashid",  1700000001L, "James"));
            guests.add(new Vip     (2, "Sophia Chen",      1700000002L, "Maria"));
            guests.add(new Business(3, "Karim Hossain",    1700000003L, "TechCorp BD"));
            guests.add(new Business(4, "Priya Sharma",     1700000004L, "GlobalTrade"));
        } catch (GuestException e) {
            showError("Guest seed error: " + e.getMessage());
        }
        try {
            Reservation r1 = new OnlineReservation(
                    LocalDate.now(), LocalDate.now().plusDays(3),
                    guests.get(0), rooms.get(2), "Confirmed", 8500,
                    "Card", "TXN-001", "01700000001");
            resControl.AddReservation(r1);
            reservations.add(r1);
            rooms.get(2).reserveRoom();

            Reservation r2 = new OfflineReservation(
                    LocalDate.now().plusDays(1), LocalDate.now().plusDays(5),
                    guests.get(2), rooms.get(4), "Pending", 15000,
                    "Front Desk", "Receptionist");
            resControl.AddReservation(r2);
            reservations.add(r2);
        } catch (InvalidReservationException e) {
            showError("Reservation seed error: " + e.getMessage());
        }
    }


    JPanel buildSidebar() {
        JPanel sb = new JPanel();
        sb.setBackground(PANEL);
        sb.setLayout(new BoxLayout(sb, BoxLayout.Y_AXIS));
        sb.setPreferredSize(new Dimension(200, 0));
        sb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));

        // logo
        JPanel logo = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 20));
        logo.setBackground(PANEL);
        JLabel lbl = new JLabel("🏨 Hotel MS");
        lbl.setFont(HEADING);
        lbl.setForeground(ACCENT);
        logo.add(lbl);
        sb.add(logo);

        addSep(sb);

        String[][] navItems = {
                {"📊","Dashboard"},
                {"🛏","Rooms"},
                {"👤","Guests"},
                {"📋","Reservations"},
                {"🏋","Facilities"},
                {"👷","Employees"},
        };

        for (String[] item : navItems) {
            JButton btn = navButton(item[0] + "  " + item[1]);
            btn.addActionListener(e -> {
                resetNavButtons(sb);
                btn.setBackground(CARD);
                btn.setForeground(ACCENT);
                switch (item[1]) {
                    case "Dashboard"   -> showDashboard();
                    case "Rooms"       -> showRooms();
                    case "Guests"      -> showGuests();
                    case "Reservations"-> showReservations();
                    case "Facilities"  -> showFacilities();
                    case "Employees"   -> showEmployees();
                }
            });
            sb.add(btn);
        }

        sb.add(Box.createVerticalGlue());
        return sb;
    }

    JButton navButton(String text) {
        JButton b = new JButton(text);
        b.setFont(BODY);
        b.setForeground(TEXT_DIM);
        b.setBackground(PANEL);
        b.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setMaximumSize(new Dimension(200, 48));
        return b;
    }

    void resetNavButtons(JPanel sb) {
        for (Component c : sb.getComponents())
            if (c instanceof JButton b) {
                b.setBackground(PANEL);
                b.setForeground(TEXT_DIM);
            }
    }

    JPanel buildContent() {
        mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(BG);
        return mainContent;
    }

    JPanel buildStatusBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 6));
        bar.setBackground(new Color(10, 14, 26));
        statusBar = new JLabel("Ready");
        statusBar.setFont(MONO);
        statusBar.setForeground(TEXT_DIM);
        bar.add(statusBar);
        return bar;
    }

    void setContent(JPanel p) {
        mainContent.removeAll();
        mainContent.add(p, BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }

    void setStatus(String msg) { statusBar.setText(msg); }


    void showDashboard() {
        JPanel p = bgPanel(new BorderLayout(0, 0));

        // header
        JPanel hdr = bgPanel(new FlowLayout(FlowLayout.LEFT, 24, 20));
        JLabel title = new JLabel("Dashboard");
        title.setFont(TITLE); title.setForeground(TEXT);
        hdr.add(title);
        p.add(hdr, BorderLayout.NORTH);

        // stat cards row
        JPanel cards = bgPanel(new GridLayout(1, 4, 16, 0));
        cards.setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 24));

        long avail   = rooms.stream().filter(Room::isAvailable).count();
        long occupied= rooms.size() - avail;
        long pending  = reservations.stream().filter(r -> "Pending".equalsIgnoreCase(r.getStatus())).count();

        cards.add(statCard("Total Rooms",    String.valueOf(rooms.size()),        ACCENT));
        cards.add(statCard("Available",      String.valueOf(avail),               SUCCESS));
        cards.add(statCard("Occupied",       String.valueOf(occupied),            DANGER));
        cards.add(statCard("Total Guests",   String.valueOf(guests.size()),       ACCENT2));

        JPanel mid = bgPanel(new BorderLayout());
        mid.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        mid.add(cards, BorderLayout.NORTH);

        // recent reservations table
        JLabel rl = new JLabel("Recent Reservations");
        rl.setFont(HEADING); rl.setForeground(TEXT);
        rl.setBorder(BorderFactory.createEmptyBorder(24, 0, 12, 0));
        mid.add(rl, BorderLayout.CENTER);

        String[] cols = {"Guest","Room","Arrival","Departure","Status","Type","Total Cost"};
        Object[][] data = reservationTableData();
        mid.add(styledScroll(styledTable(cols, data)), BorderLayout.SOUTH);

        p.add(mid, BorderLayout.CENTER);
        setContent(p);
        setStatus("Dashboard loaded — " + rooms.size() + " rooms, " + guests.size() + " guests");
    }


    void showRooms() {
        JPanel p = bgPanel(new BorderLayout());

        JPanel hdr = buildPageHeader("Rooms", "Add Room", e -> addRoomDialog());
        p.add(hdr, BorderLayout.NORTH);

        String[] cols = {"Room No","Type","Floor","Cost/Night","Capacity","Available"};
        Object[][] data = new Object[rooms.size()][6];
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            data[i] = new Object[]{r.getRoomNumber(), r.getRoomType(), r.getFloorLevel(),
                    "BDT " + r.getCostPerNight(), r.getMaxOccupancy(),
                    r.isAvailable() ? "✅ Yes" : "❌ No"};
        }

        JPanel body = bgPanel(new BorderLayout());
        body.setBorder(BorderFactory.createEmptyBorder(16, 24, 24, 24));
        body.add(styledScroll(styledTable(cols, data)), BorderLayout.CENTER);
        p.add(body, BorderLayout.CENTER);

        setContent(p);
        setStatus("Rooms: " + rooms.stream().filter(Room::isAvailable).count() + " available");
    }

    void addRoomDialog() {
        JDialog dlg = dialog("Add New Room", 420, 420);
        JPanel form = formPanel();

        JComboBox<String> type = combo("Single Room", "Luxury Room", "Duplex Room");
        JTextField roomNo   = field("e.g. 103");
        JTextField floor    = field("e.g. 1");
        JTextField cost     = field("e.g. 5000");
        JTextField extra    = field("e.g. King  /  2 levels");
        JCheckBox  fridge   = new JCheckBox("Has Fridge");
        fridge.setBackground(CARD); fridge.setForeground(TEXT); fridge.setFont(BODY);

        form.add(label("Room Type")); form.add(type);
        form.add(label("Room Number")); form.add(roomNo);
        form.add(label("Floor Level")); form.add(floor);
        form.add(label("Cost Per Night")); form.add(cost);
        form.add(label("Bed Type / Levels")); form.add(extra);
        form.add(label("")); form.add(fridge);

        JButton save = accentButton("Add Room");
        save.addActionListener(e -> {
            try {
                String t = (String) type.getSelectedItem();
                Room r;
                if ("Single Room".equals(t))
                    r = new SingleRoom(roomNo.getText(), parseInt(floor), parseDouble(cost), false, true, true);
                else if ("Luxury Room".equals(t))
                    r = new LuxuryRoom(roomNo.getText(), parseInt(floor), parseDouble(cost), fridge.isSelected(), true, extra.getText().isBlank() ? "King" : extra.getText());
                else
                    r = new DuplexRoom(roomNo.getText(), parseInt(floor), parseDouble(cost), extra.getText().isBlank() ? 2 : parseInt(extra), true);
                rooms.add(r);
                dlg.dispose();
                showRooms();
                setStatus("Room " + r.getRoomNumber() + " added.");
            } catch (Exception ex) { showError(ex.getMessage()); }
        });

        dlg.add(form, BorderLayout.CENTER);
        dlg.add(btnPanel(save), BorderLayout.SOUTH);
        dlg.setVisible(true);
    }


    void showGuests() {
        JPanel p = bgPanel(new BorderLayout());
        p.add(buildPageHeader("Guests", "Add Guest", e -> addGuestDialog()), BorderLayout.NORTH);

        String[] cols = {"ID","Name","Phone","Type","Room","Checked In"};
        Object[][] data = new Object[guests.size()][6];
        for (int i = 0; i < guests.size(); i++) {
            Guest g = guests.get(i);
            String type = (g instanceof Vip) ? "VIP" : "Business";
            data[i] = new Object[]{g.getGuestID(), g.getGuestName(), g.getPhoneNumber(),
                    type, g.getRoomNumber() == 0 ? "—" : String.valueOf(g.getRoomNumber()),
                    g.isCheckedIn() ? "✅ Yes" : "❌ No"};
        }

        JPanel body = bgPanel(new BorderLayout());
        body.setBorder(BorderFactory.createEmptyBorder(16, 24, 24, 24));
        body.add(styledScroll(styledTable(cols, data)), BorderLayout.CENTER);
        p.add(body, BorderLayout.CENTER);

        setContent(p);
        setStatus("Total guests: " + guests.size());
    }

    void addGuestDialog() {
        JDialog dlg = dialog("Add New Guest", 400, 360);
        JPanel form = formPanel();

        JComboBox<String> type = combo("VIP", "Business");
        JTextField id    = field("Guest ID");
        JTextField name  = field("Full name");
        JTextField phone = field("Phone number");
        JTextField extra = field("Butler name / Company name");

        form.add(label("Guest Type")); form.add(type);
        form.add(label("Guest ID"));   form.add(id);
        form.add(label("Name"));       form.add(name);
        form.add(label("Phone"));      form.add(phone);
        form.add(label("Butler / Company")); form.add(extra);

        JButton save = accentButton("Add Guest");
        save.addActionListener(e -> {
            try {
                Guest g;
                if ("VIP".equals(type.getSelectedItem()))
                    g = new Vip(parseInt(id), name.getText(), Long.parseLong(phone.getText()), extra.getText());
                else
                    g = new Business(parseInt(id), name.getText(), Long.parseLong(phone.getText()), extra.getText());
                guests.add(g);
                dlg.dispose();
                showGuests();
                setStatus("Guest " + g.getGuestName() + " added.");
            } catch (GuestException ex) { showError(ex.getMessage()); }
            catch (NumberFormatException ex) { showError("ID and phone must be numbers."); }
        });

        dlg.add(form, BorderLayout.CENTER);
        dlg.add(btnPanel(save), BorderLayout.SOUTH);
        dlg.setVisible(true);
    }


    void showReservations() {
        JPanel p = bgPanel(new BorderLayout());
        p.add(buildPageHeader("Reservations", "New Reservation", e -> addReservationDialog()), BorderLayout.NORTH);

        String[] cols = {"Guest","Room","Arrival","Departure","Status","Type","Total"};
        Object[][] data = reservationTableData();

        JTable table = styledTable(cols, data);
        JPanel body = bgPanel(new BorderLayout());
        body.setBorder(BorderFactory.createEmptyBorder(16, 24, 24, 24));

        // action buttons row
        JPanel actions = bgPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        JButton cancel = dangerButton("Cancel Selected");
        JButton confirm = successButton("Confirm Selected");

        cancel.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) { showError("Select a reservation first."); return; }
            try {
                resControl.UpdateStatus(reservations.get(row), "Cancelled");
                reservations.get(row).getRoom().cancelReservation();
                showReservations();
                setStatus("Reservation cancelled.");
            } catch (InvalidStatusException ex) { showError(ex.getMessage()); }
        });

        confirm.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) { showError("Select a reservation first."); return; }
            try {
                resControl.UpdateStatus(reservations.get(row), "Confirmed");
                showReservations();
                setStatus("Reservation confirmed.");
            } catch (InvalidStatusException ex) { showError(ex.getMessage()); }
        });

        actions.add(confirm); actions.add(cancel);
        actions.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));
        body.add(actions, BorderLayout.NORTH);
        body.add(styledScroll(table), BorderLayout.CENTER);
        p.add(body, BorderLayout.CENTER);

        setContent(p);
        setStatus("Total reservations: " + reservations.size());
    }

    void addReservationDialog() {
        if (guests.isEmpty()) { showError("Add guests first."); return; }
        JDialog dlg = dialog("New Reservation", 460, 500);
        JPanel form = formPanel();

        String[] guestNames = guests.stream().map(Guest::getGuestName).toArray(String[]::new);
        String[] roomNums   = rooms.stream().filter(Room::isAvailable).map(Room::getRoomNumber).toArray(String[]::new);

        if (roomNums.length == 0) { showError("No available rooms."); dlg.dispose(); return; }

        JComboBox<String> resType    = combo("Online", "Offline");
        JComboBox<String> guestBox   = new JComboBox<>(guestNames);
        JComboBox<String> roomBox    = new JComboBox<>(roomNums);
        JTextField arrival    = field("YYYY-MM-DD");
        JTextField departure  = field("YYYY-MM-DD");
        JTextField price      = field("e.g. 8500");
        JTextField extraField = field("TxnID / Desk name");
        JTextField extraField2= field("Phone / Employee name");

        styleCombo(guestBox); styleCombo(roomBox);

        form.add(label("Type"));         form.add(resType);
        form.add(label("Guest"));        form.add(guestBox);
        form.add(label("Room"));         form.add(roomBox);
        form.add(label("Arrival Date")); form.add(arrival);
        form.add(label("Departure"));    form.add(departure);
        form.add(label("Price (BDT)"));  form.add(price);
        form.add(label("TxnID / Desk")); form.add(extraField);
        form.add(label("Phone / Staff")); form.add(extraField2);

        JButton save = accentButton("Book Now");
        save.addActionListener(e -> {
            try {
                Guest  g = guests.get(guestBox.getSelectedIndex());
                Room   r = rooms.stream().filter(rm -> rm.getRoomNumber().equals(roomBox.getSelectedItem())).findFirst().get();
                LocalDate arr = LocalDate.parse(arrival.getText().trim());
                LocalDate dep = LocalDate.parse(departure.getText().trim());
                double pr = parseDouble(price);

                Reservation res;
                if ("Online".equals(resType.getSelectedItem()))
                    res = new OnlineReservation(arr, dep, g, r, "Pending", pr, "Card", extraField.getText(), extraField2.getText());
                else
                    res = new OfflineReservation(arr, dep, g, r, "Pending", pr, extraField.getText(), extraField2.getText());

                resControl.AddReservation(res);
                reservations.add(res);
                r.reserveRoom();
                dlg.dispose();
                showReservations();
                setStatus("Reservation created for " + g.getGuestName());
            } catch (InvalidReservationException ex) { showError(ex.getMessage()); }
            catch (Exception ex) { showError("Invalid input: " + ex.getMessage()); }
        });

        dlg.add(form, BorderLayout.CENTER);
        dlg.add(btnPanel(save), BorderLayout.SOUTH);
        dlg.setVisible(true);
    }


    void showFacilities() {
        JPanel p = bgPanel(new BorderLayout());
        JPanel hdr = bgPanel(new FlowLayout(FlowLayout.LEFT, 24, 20));
        JLabel t = new JLabel("Facilities"); t.setFont(TITLE); t.setForeground(TEXT); hdr.add(t);
        p.add(hdr, BorderLayout.NORTH);

        JPanel cards = bgPanel(new GridLayout(1, 2, 20, 0));
        cards.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        Gym gym = new Gym();
        SwimmingPool pool = new SwimmingPool();

        cards.add(facilityCard("🏋 " + gym.getFacilityName(), "Monthly fee: BDT " + gym.getFee(), "Open 6AM - 10PM\nEquipped with modern machines", SUCCESS));
        cards.add(facilityCard("🏊 " + pool.getFacilityName(), "Per visit: BDT " + pool.getFee(), "Open 7AM - 8PM\nHeated pool, 25m length", ACCENT));

        p.add(cards, BorderLayout.CENTER);
        setContent(p);
        setStatus("2 facilities available");
    }


    void showEmployees() {
        JPanel p = bgPanel(new BorderLayout());
        p.add(buildPageHeader("Employees", null, null), BorderLayout.NORTH);

        Employee[] emps = {
                new Manager("Shoriful Shuvo", 101, 80000),
                new Receptionist("Rifat", 102, 40000),
                new Receptionist("Mubin", 103, 40000),
                new Attendant("Ahad", 104, 30000),
                new Attendant("Rahid", 105, 30000),
                new Porter("Rafi", 106, 25000),
                new Porter("Hasan", 107, 25000),
                new Porter("Akash", 108, 25000),
        };

        String[] cols = {"ID","Name","Role","Salary (BDT)"};
        Object[][] data = new Object[emps.length][4];
        for (int i = 0; i < emps.length; i++) {
            data[i] = new Object[]{emps[i].getEmployeeId(), emps[i].getEmployeeName(),
                    emps[i].getEmployeeRole(), emps[i].getEmployeeSalary()};
        }

        JPanel body = bgPanel(new BorderLayout());
        body.setBorder(BorderFactory.createEmptyBorder(16, 24, 24, 24));
        body.add(styledScroll(styledTable(cols, data)), BorderLayout.CENTER);
        p.add(body, BorderLayout.CENTER);

        setContent(p);
        setStatus("Total employees: " + emps.length);
    }


    JPanel statCard(String title, String value, Color accent) {
        JPanel c = new JPanel(new BorderLayout());
        c.setBackground(CARD);
        c.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(accent, 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        JLabel v = new JLabel(value);
        v.setFont(new Font("SansSerif", Font.BOLD, 32));
        v.setForeground(accent);
        JLabel t = new JLabel(title);
        t.setFont(BODY); t.setForeground(TEXT_DIM);
        c.add(v, BorderLayout.CENTER);
        c.add(t, BorderLayout.SOUTH);
        return c;
    }

    JPanel facilityCard(String name, String fee, String desc, Color accent) {
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.setBackground(CARD);
        c.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(accent, 1, true),
                BorderFactory.createEmptyBorder(24, 24, 24, 24)
        ));
        JLabel n = new JLabel(name); n.setFont(HEADING); n.setForeground(accent);
        JLabel f = new JLabel(fee);  f.setFont(BODY);    f.setForeground(TEXT);
        f.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
        c.add(n); c.add(f);
        for (String line : desc.split("\n")) {
            JLabel l = new JLabel("• " + line); l.setFont(BODY); l.setForeground(TEXT_DIM); c.add(l);
        }
        return c;
    }

    JPanel buildPageHeader(String title, String btnText, ActionListener action) {
        JPanel h = new JPanel(new BorderLayout());
        h.setBackground(BG);
        h.setBorder(BorderFactory.createEmptyBorder(20, 24, 8, 24));
        JLabel t = new JLabel(title); t.setFont(TITLE); t.setForeground(TEXT);
        h.add(t, BorderLayout.WEST);
        if (btnText != null) {
            JButton b = accentButton("+ " + btnText);
            b.addActionListener(action);
            h.add(b, BorderLayout.EAST);
        }
        return h;
    }

    JTable styledTable(String[] cols, Object[][] data) {
        DefaultTableModel model = new DefaultTableModel(data, cols) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable t = new JTable(model);
        t.setBackground(CARD);
        t.setForeground(TEXT);
        t.setFont(BODY);
        t.setRowHeight(36);
        t.setShowGrid(false);
        t.setIntercellSpacing(new Dimension(0, 1));
        t.setSelectionBackground(new Color(60, 90, 140));
        t.setSelectionForeground(TEXT);
        JTableHeader h = t.getTableHeader();
        h.setBackground(PANEL);
        h.setForeground(ACCENT);
        h.setFont(new Font("SansSerif", Font.BOLD, 12));
        h.setBorder(BorderFactory.createEmptyBorder());
        return t;
    }

    JScrollPane styledScroll(JTable t) {
        JScrollPane s = new JScrollPane(t);
        s.setBackground(CARD);
        s.setBorder(new LineBorder(new Color(40, 60, 90), 1));
        s.getViewport().setBackground(CARD);
        return s;
    }

    JPanel formPanel() {
        JPanel f = new JPanel(new GridLayout(0, 2, 10, 10));
        f.setBackground(CARD);
        f.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        return f;
    }

    JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(BODY); l.setForeground(TEXT_DIM);
        return l;
    }

    JTextField field(String placeholder) {
        JTextField f = new JTextField();
        f.setFont(BODY);
        f.setBackground(new Color(20, 28, 48));
        f.setForeground(TEXT);
        f.setCaretColor(ACCENT);
        f.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(50, 70, 110), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        return f;
    }

    JComboBox<String> combo(String... items) {
        JComboBox<String> c = new JComboBox<>(items);
        styleCombo(c); return c;
    }

    void styleCombo(JComboBox<?> c) {
        c.setFont(BODY);
        c.setBackground(new Color(20, 28, 48));
        c.setForeground(TEXT);
    }

    JButton accentButton(String text) {
        JButton b = new JButton(text);
        b.setFont(BODY); b.setBackground(ACCENT); b.setForeground(BG);
        b.setFocusPainted(false); b.setBorderPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return b;
    }

    JButton dangerButton(String text) {
        JButton b = new JButton(text);
        b.setFont(BODY); b.setBackground(DANGER); b.setForeground(Color.WHITE);
        b.setFocusPainted(false); b.setBorderPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        return b;
    }

    JButton successButton(String text) {
        JButton b = new JButton(text);
        b.setFont(BODY); b.setBackground(SUCCESS); b.setForeground(BG);
        b.setFocusPainted(false); b.setBorderPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        return b;
    }

    JPanel btnPanel(JButton b) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 12));
        p.setBackground(CARD); p.add(b); return p;
    }

    JDialog dialog(String title, int w, int h) {
        JDialog d = new JDialog(this, title, true);
        d.setSize(w, h);
        d.setLocationRelativeTo(this);
        d.setLayout(new BorderLayout());
        d.getContentPane().setBackground(CARD);
        return d;
    }

    JPanel bgPanel(LayoutManager lm) {
        JPanel p = new JPanel(lm);
        p.setBackground(BG); return p;
    }

    void addSep(JPanel p) {
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(40, 55, 80));
        sep.setBackground(new Color(40, 55, 80));
        sep.setMaximumSize(new Dimension(200, 1));
        p.add(sep);
    }

    void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    int    parseInt(JTextField f)    { return Integer.parseInt(f.getText().trim()); }
    int    parseInt(String s)        { return Integer.parseInt(s.trim()); }
    double parseDouble(JTextField f) { return Double.parseDouble(f.getText().trim()); }
    double parseDouble(String s)     { return Double.parseDouble(s.trim()); }

    Object[][] reservationTableData() {
        Object[][] data = new Object[reservations.size()][7];
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            String type = (r instanceof OnlineReservation) ? "Online" : "Offline";
            data[i] = new Object[]{
                    r.getGuest() != null ? r.getGuest().getGuestName() : "—",
                    r.getRoom()  != null ? r.getRoom().getRoomNumber()  : "—",
                    r.getArrivalDate(), r.getDepartureDate(),
                    r.getStatus(), type,
                    "BDT " + r.CalculateTotalcost()
            };
        }
        return data;
    }


    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(HotelGUI::new);
    }
}
