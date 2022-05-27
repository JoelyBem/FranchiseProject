package com.douane.entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.douane.model.FEtatDemande;

@Entity
public class Demande implements Serializable{
	//private static final String mappedBy = null;

	@Id
	@SequenceGenerator (name = "generatorClient", sequenceName = "CL_SEQ", allocationSize = 1) 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generatorClient")
	private Long id;
	
	private String numeroDemande;
	
	//@ManyToOne(cascade = {CascadeType.ALL})
	@OneToOne
	@JoinColumn(name="idTypeFranchise")
	private FTypeFranchise typeFranchise;
	
	@Enumerated(EnumType.STRING)
	private FEtatDemande etatDemande = FEtatDemande.EN_ATTENTE;
	
	private Date dateDepot;
	private Date dateFin;
	private boolean presence;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idAgent")
	private Utilisateur agent;
	
	@OneToOne
	@JoinColumn(name="idCuo")
	private FCuo fcuo;
	
	@OneToOne
	@JoinColumn(name="idRequerant")
	private FRequerant frequerant;
	
	private String marchandise;
	
	@OneToMany(mappedBy="demande")
	private Collection<AttribuDemande> attributionDemande;
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Demande(FTypeFranchise typeFranchise, String motif,
			FCuo fcuo, FRequerant requerant, FDossier dossier, Marchandise marchandise, boolean presence) {
		super();
		this.typeFranchise = typeFranchise;
		//this.dateDepot = new Date();
		this.motif = motif;
		this.fcuo = fcuo;
		this.etatDemande = FEtatDemande.EN_ATTENTE;
		this.frequerant = requerant;
		this.dossier = dossier;
		this.marchandise = marchandise;
		this.presence = presence;
	}
	
	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public FRequerant getFrequerant() {
		return frequerant;
	}

	public void setFrequerant(FRequerant frequerant) {
		this.frequerant = frequerant;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public void setNumeroDemande(String numeroDemande) {
		this.numeroDemande = numeroDemande;
	}

	public void setEtatDemande(FEtatDemande etatDemande) {
		this.etatDemande = etatDemande;
	}

	public FTypeFranchise getTypeFranchise() {
		return typeFranchise;
	}

	public void setTypeFranchise(FTypeFranchise typeFranchise) {
		this.typeFranchise = typeFranchise;
	}

	public String getNumeroDemande() {
		return numeroDemande;
	}
	
	public FEtatDemande getEtatDemande() {
		return etatDemande;
	}
	public Date getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Marchandise getMarchandise() {
		return marchandise;
	}
	public void setMarchandise(Marchandise marchandise) {
		this.marchandise = marchandise;
	}

	public FCuo getFcuo() {
		return fcuo;
	}

	public void setFcuo(FCuo fcuo) {
		this.fcuo = fcuo;
	}

	public FRequerant getRequerant() {
		return frequerant;
	}

	public void setRequerant(FRequerant requerant) {
		this.frequerant = requerant;
	}

	public FDossier getDossier() {
		return dossier;
	}

	public void setDossier(FDossier dossier) {
		this.dossier = dossier;
	}
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
}
