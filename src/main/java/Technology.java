@Entity
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    privateLong id;
    private String name;

    // constructors, getter and setter methods, equals, hashcode and tostring
}