@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    privateLong id;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TechnologyCandidate> technologies = new ArrayList<>();

    // constructors, getter and setter methods, equals, hashcode and tostring
}